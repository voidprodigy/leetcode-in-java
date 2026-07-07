import java.util.*;

class RandomizedCollection {
    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random rand;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        boolean notPresent = !map.containsKey(val);
        
        // If it's the first time seeing this value, initialize its index set
        if (notPresent) {
            map.put(val, new LinkedHashSet<>());
        }
        
        // Record the new index in the map and append to the list
        map.get(val).add(list.size());
        list.add(val);
        
        return notPresent;
    }
    
    public boolean remove(int val) {
        // If it's not in our collection, we can't remove it
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }
        
        // 1. Get any arbitrary index where 'val' resides
        int indexToRemove = map.get(val).iterator().next();
        
        // 2. Clear this index from 'val's set of locations
        map.get(val).remove(indexToRemove);
        
        int lastIndex = list.size() - 1;
        int lastElement = list.get(lastIndex);
        
        // 3. If the element to remove is NOT already the last element, swap them
        if (indexToRemove < lastIndex) {
            // Overwrite the element at 'indexToRemove' with 'lastElement'
            list.set(indexToRemove, lastElement);
            
            // Update lastElement's mappings: it moved from lastIndex to indexToRemove
            map.get(lastElement).add(indexToRemove);
            map.get(lastElement).remove(lastIndex);
        }
        
        // 4. Clean up the trailing element
        list.remove(lastIndex);
        
        // If 'val' has no more instances left, remove its key from the map entirely
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        
        return true;
    }
    
    public int getRandom() {
        // Uniformly picking an index ensures proportional probability for duplicates
        return list.get(rand.nextInt(list.size()));
    }
}
/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */