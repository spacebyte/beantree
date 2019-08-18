import java.util.ArrayList;
import java.util.Date;

enum Sex {
    FEMALE,
    MALE
}

public class Bean {
    private Sex sex;
    private String name;
    private Date DOB;
    private String colour;
    private Bean mother;
    private Bean father;
    private ArrayList<Bean> mates;
    private ArrayList<Bean> pups;
    private ArrayList<Bean> siblings;

    public Bean(String name, Sex sex, Date DOB, String colour) {
        this.name = name;
        this.sex = sex;
        this.DOB = DOB;
        this.colour = colour;
        pups = new ArrayList<Bean>();
        mates = new ArrayList<Bean>();
        siblings = new ArrayList<Bean>();
    }

    public boolean isParent() {
        if (pups.size() == 0) {
            return false;
        }
        return true;
    }

    public boolean knownFather() {
        if (father == null) {
            return false;
        }
        return true;
    }

    public boolean knownMother() {
        if (mother == null) {
            return false;
        }
        return true;
    }

    //Getters and setters

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Bean getMother() {
        return mother;
    }

    public void setMother(Bean mother) {
        this.mother = mother;
        if (!mother.getPups().contains(this)) {
            mother.addPup(this);
        }
    }

    public Bean getFather() {
        return father;
    }

    public void setFather(Bean father) {
        this.father = father;
        if (!father.getPups().contains(this)) {
            father.addPup(this);
        }
    }

    public ArrayList<Bean> getMates() {
        return mates;
    }

    public void addMate(Bean mate) {
        this.mates.add(mate);
        if (!mate.getMates().contains(this)) {
            mate.addMate(this);
        }
    }

    public ArrayList<Bean> getPups() {
        return pups;
    }

    public void addPup(Bean pup) {
        this.pups.add(pup);
        if (pup.getMother() == null && this.getSex().equals(Sex.FEMALE)) {
            pup.setMother(this);
        }
        if (pup.getFather() == null && this.getSex().equals(Sex.MALE)) {
            pup.setFather(this);
        }
    }

    public ArrayList<Bean> getSiblings() {
        return siblings;
    }

    public void addSiblings(Bean sibling) {
        this.siblings.add(sibling);
        if (!sibling.getSiblings().contains(this)) {
            sibling.addSiblings(this);
        }
    }
}



