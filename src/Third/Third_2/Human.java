package Third.Third_2;

public class Human {
    private Leg[] legs;
    private Head[] heads;
    private Hand[] hands;
    int num_leg = 0, num_head = 0, num_hand = 0;

    public Human(int num_leg, int num_head, int num_hands){
        legs = new Leg[num_leg];
        heads = new Head[num_head];
        hands = new Hand[num_hands];
    }

    public Leg[] getLegs() {return legs;}
    public Head[] getHeads() {return heads;}
    public Hand[] getHands() {return hands;}

    public void addLeg(int length){legs[num_leg] = new Leg(length);num_leg++;}
    public void addHead(int diametr){heads[num_head] = new Head(diametr);num_head++;}
    public void addHand(int heft){hands[num_hand] = new Hand(heft);num_hand++;}

    @Override
    public String toString() {
        String tmp = "";
        for (int i = 0;i< legs.length;i++){tmp += "Моя " +(i+1) + " нога в длину " + legs[i].getLength() + " cм\n";}
        for (int i = 0;i< heads.length;i++){tmp += "Диаметр моей " +(i+1) + " головы " + legs[i].getLength() + " см\n";}
        for (int i = 0;i< hands.length;i++){tmp += "Вес моей " +(i+1) + " руки " + legs[i].getLength() + " кг\n";}
        return tmp;
    }

    private class Leg{
        private float length = -1;
        public Leg(int length){this.length = length;}
        public float getLength() {return length;}
        public void setLength(float length){this.length = length;}
    }

    private class Head{
        private int diametr = -1;
        public Head(int diametr){this.diametr = diametr;}
        public int getDiametr() {return diametr;}
        public void setDiametr(int diametr) {this.diametr = diametr;}
    }

    private class Hand{
        private int heft = -1;
        public Hand(int heft){this.heft = heft;}
        public int getHeft() {return heft;}
        public void setHeft(int heft) {this.heft = heft;}
    }
}