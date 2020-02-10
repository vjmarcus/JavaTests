package equals;

public class Address {
    public static void main(String[] args) {
        Address address1 = new Address("Russia", "Lorina street", 32);
        Address address2 = new Address("Russia", "Lorina street", 32);
        address1.ifEquals(address1, address2);
        address1 = address2;
        address1.ifEquals(address1, address2);
        Address address3 = new Address("Russia", "Lorina street", 32);
        System.out.println(address1.equals(address3));
    }
    void ifEquals(Address address1, Address address2) {
        if (address1 == address2) {
            System.out.println("Равны");
        } else {
            System.out.println("Не равны");
        }
    }
    private String city;
    private String street;
    private int numberOfHouse;

    public Address(String city, String street, int numberOfHouse) {
        this.city = city;
        this.street = street;
        this.numberOfHouse = numberOfHouse;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumberOfHouse() {
        return numberOfHouse;
    }

    public void setNumberOfHouse(int numberOfHouse) {
        this.numberOfHouse = numberOfHouse;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            return this.city.equals(address.city) && this.street.equals(address.street) && this.numberOfHouse == address.numberOfHouse;
        } else {
            return false;
        }
    }
}

