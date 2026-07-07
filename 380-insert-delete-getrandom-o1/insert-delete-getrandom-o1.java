import java.util.*;

class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random rand;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        // If it already exists, don't insert
        if (map.containsKey(val)) {
            return false;
        }
        
        // Map the value to its incoming index (the current size of the list)
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        // If it doesn't exist, we can't remove it
        if (!map.containsKey(val)) {
            return false;
        }
        
        // Get the index of the element to remove
        int indexToRemove = map.get(val);
        int lastElement = list.get(list.size() - 1);
        
        // Move the last element to the position of the element we want to delete
        list.set(indexToRemove, lastElement);
        map.put(lastElement, indexToRemove); // Update its index in the map
        
        // Remove the last element from the list and delete the target from the map
        list.remove(list.size() - 1);
        map.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        // Pick a completely random index from the list
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */