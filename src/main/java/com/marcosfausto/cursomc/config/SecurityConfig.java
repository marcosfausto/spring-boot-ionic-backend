package com.marcosfausto.cursomc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Environment env;

    // Lista de end points sempre permitidos
    private static final String[] PUBLIC_MATCHERS = {
            "/h2-console/**",
    };

    // Lista de end points sempre permitidos ( apenas para GET )
    private static final String[] PUBLIC_MATCHERS_GET = {
            "/produtos/**",
            "/clientes/**",
            "/categorias/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        // se o profile ativo for teste podemos acessar o bd h2
        if(Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }

        // adiciona a config do cors e desabilita o CSRF
        http.cors().and().csrf().disable();

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll() // permite apenas GET para a lista em questão
                .antMatchers(PUBLIC_MATCHERS).permitAll() // Permite todos os métodos HTTP
                .anyRequest().authenticated(); // qualquer outro request, necessita autenticação
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // assegurar que o back-end nao vai criar sessao de usuário

    }

    // permite o acesso a todos os end points com configurações default
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
