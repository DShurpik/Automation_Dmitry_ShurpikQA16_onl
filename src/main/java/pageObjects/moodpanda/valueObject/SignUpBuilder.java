package pageObjects.moodpanda.valueObject;

import lombok.Data;

@Data

public class SignUpBuilder {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean checkbox;


    public static class Builder{ // создается внутренний статический класс, в котором происходит реализация внешнего класса
        private SignUpBuilder signUpBuilder; // переменная экземпляра(объекта) внешнего класса

        public Builder withFirstName(String firstName) {
            signUpBuilder.firstName = firstName;
            return this;
        }

        // через сеттеры происходит наполнение данными, все сеттеры начинаются с with

        public Builder withLastName(String lastName) {
            signUpBuilder.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email) {
            signUpBuilder.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            signUpBuilder.password = password;
            return this;
        }

        public Builder withCheckbox(Boolean checkbox) {
            signUpBuilder.checkbox = checkbox;
            return this;
        }

        public Builder(){ // создается конструктор статического(внутреннего) класса, который инициализирует объект внешнего класса
            this.signUpBuilder = new SignUpBuilder();
        }

        public SignUpBuilder build(){ // вызывается в конце и возвращает собранный объект с заполненными полями с помощью сеттеров
            return signUpBuilder;
        }
    }
    @Override
    public String toString() {
        return "SignUpBuilder{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", checkbox=" + checkbox +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getCheckbox() {
        return checkbox;
    }


}
