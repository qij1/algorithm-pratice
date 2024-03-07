package stackqueue.dogcatqueue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedBlockingDeque<PetEnterQueue>();
        this.catQ = new LinkedBlockingDeque<PetEnterQueue>();
    }

    public void add(Pet pet) {
        if(pet.getType().equals("dog")) {
            this.dogQ.add(new PetEnterQueue(pet, this.count++));
        } else if(pet.getType().equals("cat")) {
            this.catQ.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("err, not dog or cat");
        }
    }

    public Pet pollAll() {
        if(!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
            if(dogQ.peek().getCount() > catQ.peek().getCount()) {
                return catQ.poll().getPet();
            } else {
                return dogQ.poll().getPet();
            }
        } else if(!this.dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else if(!this.catQ.isEmpty()){
            return catQ.poll().getPet();
        } else {
            throw new RuntimeException("err, queue is empty!");
        }
    }

    public Pet pollDog() {
        if(!dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else {
            throw new RuntimeException("err, dog queue is empty!");
        }
    }

    public Pet pollCat() {
        if(!catQ.isEmpty()) {
            return catQ.poll().getPet();
        } else {
            throw new RuntimeException("err, cat queue is empty!");
        }
    }

}
