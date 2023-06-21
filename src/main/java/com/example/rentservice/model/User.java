package com.example.rentservice.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role", referencedColumnName = "id")
    private Role role;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_extra_users_data", referencedColumnName = "id")
    private ExtraUserData extraUserData;

    public Changer changer() {
        return new Changer();
    }

    /**
     * like builder but changer
     */
    public class Changer {

        private Changer() {
        }

        public Changer login(String login) {
            if (!User.this.login.equals(login) && login != null) {
                User.this.login = login;
            }
            return this;
        }

        public Changer password(String password) {
            if (!User.this.password.equals(password) && password != null) {
                User.this.password = password;
            }
            return this;
        }

        public Changer role(Role role) {
            if (!User.this.role.equals(role) && role != null) {
                User.this.role = role;
            }
            return this;
        }

        public Changer extraUserData(ExtraUserData extraUserData) {
            if (!User.this.extraUserData.equals(extraUserData) && extraUserData != null) {
                User.this.extraUserData = extraUserData;
            }
            return this;
        }

        public User change() {
            return User.this;
        }
    }

}
