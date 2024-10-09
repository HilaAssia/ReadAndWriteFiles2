package com.example.oct10;

public class Person {
    public String firstName,lastName,phone;
    public Gender gender;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public Gender getGender() {
        return gender;
    }

    public enum Gender
    {
        Male, Female, Transgender
    }

    static class GenderUtils {
        public static int setImage(Gender g) {
            switch (g) {
                case Male:
                    return R.drawable.male;
                case Female:
                    return R.drawable.female;
                case Transgender:
                    return R.drawable.transgender;
                default:
                    return R.drawable.unknown;
            }
        }
    }

}
