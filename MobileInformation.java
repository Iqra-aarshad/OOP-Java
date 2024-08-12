import java.util.ArrayList;
import java.util.List;

 class MobilePhone {
    String brand;
    String model;
    double price;
    double storageCapacity;

    public MobilePhone(String brand, String model, double price, double storageCapacity) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.storageCapacity = storageCapacity;
    }

    public void displayPhoneDetails() {
        System.out.println("Display Details.");
        System.out.println("Brand:" + brand);
        System.out.println("Model:" + model);
        System.out.println("Price:" + price);
        System.out.println("Storage Capacity: " + storageCapacity);
    }

    public int comparePrice(MobilePhone other) {
        return Double.compare(this.price, other.price);
    }

    public boolean meetsRequirements(double minStorage, double maxPrice) {
        return this.storageCapacity >= minStorage && this.price <= maxPrice;
    }
}
class MobileInformation{

    public static void main(String[] args) {
        List<MobilePhone> phones = new ArrayList<>();
        phones.add(new MobilePhone("Samsung", "Galaxy A53", 35000, 128));
        phones.add(new MobilePhone("Tecno", "SPARK 20 PRO", 3000, 16));
        phones.add(new MobilePhone("Realme", "C35", 10000, 32));

        for (MobilePhone phone : phones) {
            phone.displayPhoneDetails();
        }

        MobilePhone highestStoragePhone = phones.get(0);
        for (MobilePhone phone : phones) {
            if (phone.storageCapacity > highestStoragePhone.storageCapacity) {
                highestStoragePhone = phone;
            }
        }

        System.out.println("Phone with highest storage capacity:");
        highestStoragePhone.displayPhoneDetails();

        double minStorage = 32;
        double maxPrice = 15000;
        for (MobilePhone phone : phones) {
            if (phone.meetsRequirements(minStorage, maxPrice)) {
                System.out.println(phone.brand + " " + phone.model + " meets the requirements.");
            } else {
                System.out.println(phone.brand + " " + phone.model + " does not meet the requirements.");
            }
        }
    }
}
