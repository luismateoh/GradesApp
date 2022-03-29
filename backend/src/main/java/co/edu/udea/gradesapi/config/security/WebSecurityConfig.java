package co.edu.udea.gradesapi.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/periods", "/periods/**").hasAnyAuthority(ADMIN, TUTOR)
                .antMatchers(HttpMethod.GET, "/users/me").hasAnyAuthority(ADMIN, TUTOR, STUDENT)
                .antMatchers("/periods", "/periods/**").hasAuthority(ADMIN)
                .antMatchers("/users", "/users/**").hasAuthority(ADMIN)
                .antMatchers("/institutions", "/institutions/**").hasAuthority(ADMIN)
                .antMatchers("/subjects", "/subjects/**").hasAuthority(ADMIN)
                .antMatchers("/grades", "/grades/**").hasAuthority(ADMIN)
                .antMatchers("/grades-definitions", "/grades-definitions/**").hasAuthority(ADMIN)
                .antMatchers("/subjects-registration", "/subjects-registration/**").hasAuthority(ADMIN)
                .antMatchers("/public/**", "/auth/**").permitAll()
                .antMatchers("/", "/error", "/csrf", "/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs", "/v3/api-docs/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.cors().and().csrf().disable();
    }

    public static final String ADMIN = "ADMIN";
    public static final String TUTOR = "TUTOR";
    public static final String STUDENT = "STUDENT";
}
