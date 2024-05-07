public class Flavors {
    public String IceCreamFlavors;

    public String ServingStyle;

    public String IceCreamToppings;

    public Flavors (){
        this.IceCreamFlavors = "Vanilla";
        this.ServingStyle = "waflle cones";
        this.IceCreamToppings = "NA";
    }

    public String getIceCreamFlavors(){
        return IceCreamFlavors;
    }

    public void setIceCreamFlavors(String IceCreamFlavors){
        this.IceCreamFlavors = IceCreamFlavors;
    }
    public String getServingStyle() {
        return ServingStyle;
    }
    public void setServingStyle(String ServingStyle) {
        this.ServingStyle = ServingStyle;
    }

    public String getIceCreamToppings() {
        return IceCreamToppings;
    }

    public void setIceCreamToppings(String IceCreamToppings) {
        this.IceCreamToppings = IceCreamToppings;
    }
}


