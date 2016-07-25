package stackAndqueue.catAndDogQueue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by LXF on 2016/7/25.
 */
public class CatAndDogQueue {
    private Queue<PetEnterQueue> dogQ = new LinkedList();
    private Queue<PetEnterQueue> catQ = new LinkedList();
    private long count = 0;

    public CatAndDogQueue() {
    }

    public void add(Pet pet) {
        if(pet.getPetType().equals("dog")) {
            this.dogQ.add(new PetEnterQueue(pet, (long)(this.count++)));
        } else {
            if(!pet.getPetType().equals("cat")) {
                throw new RuntimeException("err,not dog or cat");
            }

            this.catQ.add(new PetEnterQueue(pet, (long)(this.count++)));
        }

    }

    public Pet pollAll() {
        if(!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
            return (this.dogQ.peek()).getCount() < (this.catQ.peek()).getCount()?(this.dogQ.poll()).getPet():(this.catQ.poll()).getPet();
        } else if(!this.dogQ.isEmpty()) {
            return (this.dogQ.poll()).getPet();
        } else if(!this.catQ.isEmpty()) {
            return (this.catQ.poll()).getPet();
        } else {
            throw new RuntimeException("err,queue is empty");
        }
    }

    public Dog pollDog() {
        if(!this.isDogQueueEmpty()) {
            return (Dog)this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("Dog queue is empty");
        }
    }

    public Cat pollCat() {
        if(!this.isCatQueueEmpty()) {
            return (Cat)this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("Cat queue is empty");
        }
    }

    public boolean isEmpty() {
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }

    public boolean isDogQueueEmpty() {
        return this.dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty() {
        return this.catQ.isEmpty();
    }

    @Test
    public void test() {
        CatAndDogQueue catAndDogQueue = new CatAndDogQueue();
        catAndDogQueue.add(new Dog("dog"));
        catAndDogQueue.add(new Dog("dog"));
        catAndDogQueue.add(new Cat("cat"));
        catAndDogQueue.add(new Cat("cat"));
        System.out.println(catAndDogQueue.isDogQueueEmpty());
        System.out.println(catAndDogQueue.isCatQueueEmpty());
        System.out.println(catAndDogQueue.pollCat().getPetType());
        System.out.println(catAndDogQueue.pollDog().getPetType());
        catAndDogQueue.pollAll();
        System.out.println(catAndDogQueue.isEmpty());
        System.out.println(catAndDogQueue.pollCat());
        System.out.println(catAndDogQueue.pollDog());
    }

}
