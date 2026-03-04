package dto.request;

import utils.DataGenerator;

public class UpdatePlayerRequest {
    private Integer age;
    private String gender;
    private String login;
    private String password;
    private String screenName;

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getScreenName() { return screenName; }
    public void setScreenName(String screenName) { this.screenName = screenName; }

    // ===== Builder =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer age = DataGenerator.randomAge();
        private String gender = DataGenerator.randomGender();
        private String login = DataGenerator.randomString(8);
        private String password = DataGenerator.randomString(10);
        private String screenName = DataGenerator.randomString(6);

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

        public Builder screenName(String screenName) {
            this.screenName = screenName;
            return this;
        }

        public UpdatePlayerRequest build() {
            UpdatePlayerRequest request = new UpdatePlayerRequest();
            request.setAge(this.age);
            request.setGender(this.gender);
            request.setLogin(this.login);
            request.setPassword(this.password);
            request.setScreenName(this.screenName);
            return request;
        }
    }
}