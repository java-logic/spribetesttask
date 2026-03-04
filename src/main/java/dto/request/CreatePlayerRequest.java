package dto.request;

import constant.Role;
import utils.DataGenerator;

public class CreatePlayerRequest {
    private Role editor;
    private Integer age;
    private String gender;
    private String login;
    private String password;
    private String role;
    private String screenName;

    // Геттери та сеттери
    public Role getEditor() {
        return editor;
    }

    public void setEditor(Role editor) {
        this.editor = editor;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    // ======= Builder =======
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Role editor = Role.SUPERVISOR;
        private Integer age = DataGenerator.randomAge();
        private String gender = DataGenerator.randomGender();
        private String login = DataGenerator.randomString(8);
        private String password = DataGenerator.randomString(8);
        private String role = DataGenerator.randomRole();
        private String screenName = DataGenerator.randomString(6);

        public Builder editor(Role editor) {
            this.editor = editor;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Builder screenName(String screenName) {
            this.screenName = screenName;
            return this;
        }

        public CreatePlayerRequest build() {
            CreatePlayerRequest request = new CreatePlayerRequest();
            request.setEditor(this.editor);
            request.setAge(this.age);
            request.setGender(this.gender);
            request.setLogin(this.login);
            request.setPassword(this.password);
            request.setRole(this.role);
            request.setScreenName(this.screenName);
            return request;
        }
    }
}