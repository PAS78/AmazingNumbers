class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.equals("")) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.equals("")) {
            this.lastName = lastName;
        }
    }

    public String getFullName() {
        if (firstName == null) {
            firstName = "";
        }

        if (lastName == null) {
            lastName = "";
        }

        if (firstName.isEmpty() && lastName.isEmpty()) {
            return "Unknown";
        } else if (firstName.isEmpty()) {
            return (lastName).trim();
        } else
            return (firstName + " " + lastName).trim();

    }
}