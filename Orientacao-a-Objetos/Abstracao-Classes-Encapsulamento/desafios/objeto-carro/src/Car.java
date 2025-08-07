public class Car {
    private int velocity = 0;
    private boolean on = false;
    private int gear = 0;
    Car(){

    }
    public int getVelocity(){
        return this.velocity;
    }


    public String speedUp(){
        if (!this.on){
            return "Car is off, can't Speed Up";
        }
        boolean canSpeedUp = (
                        (this.gear == 1 && (this.velocity <20)) ||
                        (this.gear ==2 && (this.velocity <40)) ||
                        (this.gear ==3 && (this.velocity <60)) ||
                        (this.gear ==4 && (this.velocity <80)) ||
                        (this.gear ==5 && (this.velocity <100)) ||
                        (this.gear ==6 && (this.velocity <120))
        );
        if (!canSpeedUp) {
            return "Velocity wrong to this Gear!";
        }
        this.velocity += 1;
        return "Speed uped";
    }

    public String speedDown(){
        if (!this.on){
            return "Car is off, can't Speed Down";
        }
        boolean canSpeedDown = (
                        (this.gear ==1 && (this.velocity <20)) ||
                        (this.gear ==2 && (this.velocity <40)) ||
                        (this.gear ==3 && (this.velocity <=60)) ||
                        (this.gear ==4 && (this.velocity <80)) ||
                        (this.gear ==5 && (this.velocity <100)) ||
                        (this.gear ==6 && (this.velocity <120))
        );
        if (!canSpeedDown) {
            return "Velocity wrong to this Gear!";
        }
        this.velocity -= 1;
        return "Speed Down!";
    }

    public void setOn() {
        this.on = true;
    }

    public void setOnAsOff(){
        if (!this.on){
            System.out.println("Car is already off");
        }
        if (this.velocity != 0 || this.gear != 0){
            System.out.println("Gear and velocity may be zero");
        }
        this.on = false;
    }

    public String setGear(int gear){
        if (!this.on){
            return "Car is off, can't Gear shift";
        }
        boolean canShiftGear = (
                (gear == 1 && (this.velocity <=20)) ||
                (gear ==2 && (this.velocity <=40 && this.velocity >= 20)) ||
                (gear ==3 && (this.velocity <=60&& this.velocity >= 40)) ||
                (gear ==4 && (this.velocity <=80&& this.velocity >= 60)) ||
                (gear ==5 && (this.velocity <=100&& this.velocity >= 80)) ||
                (gear ==6 && (this.velocity <=120&& this.velocity >= 100))
        );
        if (!canShiftGear){
            return "Velocity is wrong to this gear";
        }
        this.gear = gear;
        return "changed gear";
    }

    public String turnRight(){
        if (this.velocity < 1){
            return "You can't turn, velocity is less than 1";
        }
        if (this.velocity >40){
            return "You can't turn, velocity is bigger than 1";
        }
        return "Turning right";
    }
    public String turnLeft(){
        if (this.velocity < 1){
            return "You can't turn, velocity is less than 1";
        }
        if (this.velocity >40){
            return "You can't turn, velocity is bigger than 1";
        }
        return "Turning left";
    }
}
