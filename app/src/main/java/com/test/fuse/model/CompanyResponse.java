package com.test.fuse.model;

// Model for Company response
public class CompanyResponse {

    private String name;
    private String logo;
    private String custom_color;
    private PasswordChanging passwordChanging;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public PasswordChanging getPasswordChanging() {
        return passwordChanging;
    }

    public void setPasswordChanging(PasswordChanging passwordChanging) {
        this.passwordChanging = passwordChanging;
    }

    public String getCustom_color() {
        return custom_color;
    }

    public void setCustom_color(String custom_color) {
        this.custom_color = custom_color;
    }

    public class PasswordChanging {

        private boolean enabled;
        private String secure_field;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getSecure_field() {
            return secure_field;
        }

        public void setSecure_field(String secure_field) {
            this.secure_field = secure_field;
        }
    }
}