class Phone {
    private int camera;
    private String name;

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public int getCamera() {
        return camera;
    }

}

class Samsung extends Phone {
    private String model;

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}

class Iphone extends Phone {
    private String model;

    Iphone(String model, int camera) {
        this.model = model;
        super.setCamera(camera);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}

public class oops {
    public static void main(String[] args) {
        Phone iPhone = new Phone();
        iPhone.setCamera(9);
        System.out.println("Camera mp of iphone : " + iPhone.getCamera());

        Samsung galaxy = new Samsung();
        galaxy.setModel("Galaxy A31");
        galaxy.setCamera(100);
        System.out.println("Camera mp of " + galaxy.getModel() + " " + galaxy.getCamera());

        // for Iphone
        Iphone iphone2 = new Iphone("Iphone 14", 12);
        System.out.println(iphone2.getModel());
        System.out.println("Camera mp of " + iphone2.getModel() + ": " + iphone2.getCamera());

    }
}
