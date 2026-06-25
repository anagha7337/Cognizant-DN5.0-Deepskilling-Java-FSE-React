class Computer
{
    private String cpu;
    private String ram;
    private String storage;
    private boolean graphicsCard;
    private boolean wifi;

    private Computer(Builder builder)
    {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.wifi = builder.wifi;
    }

    public void display()
    {
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + storage);
        System.out.println("Graphics Card: " + graphicsCard);
        System.out.println("WiFi: " + wifi);
        System.out.println();
    }

    public static class Builder
    {
        private String cpu;
        private String ram;
        private String storage;
        private boolean graphicsCard;
        private boolean wifi;

        public Builder(String cpu, String ram)
        {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder setStorage(String storage)
        {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(boolean graphicsCard)
        {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setWifi(boolean wifi)
        {
            this.wifi = wifi;
            return this;
        }

        public Computer build()
        {
            return new Computer(this);
        }
    }
}

public class BuilderPatternExample
{
    public static void main(String[]args)
    {
        Computer gamingPC = new Computer.Builder(
            "Intel i9",
            "32 GB")
            .setStorage("1 TB SSD")
            .setGraphicsCard(true)
            .setWifi(true)
            .build();

        Computer officePC = new Computer.Builder(
            "Intel i5",
            "8 GB")
            .setStorage("512 GB SSD")
            .setWifi(true)
            .build();

            System.out.println("Gaming PC:");
            gamingPC.display();

            System.out.println("Office PC:");
            officePC.display();
    }
}