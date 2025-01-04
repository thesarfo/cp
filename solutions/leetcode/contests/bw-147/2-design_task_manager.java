class TaskManager {
    private class Task {
        int userId;
        int taskId;
        int priority;
        
        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }
    
    private TreeMap<Long, Task> priorityQueue;
    private HashMap<Integer, Task> taskMap;
    
    public TaskManager(List<List<Integer>> tasks) {
        priorityQueue = new TreeMap<>();
        taskMap = new HashMap<>();
        
        for (List<Integer> task : tasks) {
            add(task.get(0), task.get(1), task.get(2));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task t = new Task(userId, taskId, priority);
        taskMap.put(taskId, t);
        long key = ((long)priority << 32) | taskId;
        priorityQueue.put(key, t);
    }
    
    public void edit(int taskId, int newPriority) {
        Task t = taskMap.get(taskId);
        long ok = ((long)t.priority << 32) | taskId;
        priorityQueue.remove(ok);
        
        t.priority = newPriority;
        long nk = ((long)newPriority << 32) | taskId;
        priorityQueue.put(nk, t);
    }
    
    public void rmv(int taskId) {
        Task task = taskMap.remove(taskId);
        long k = ((long)task.priority << 32) | taskId;
        priorityQueue.remove(k);
    }
    
    public int execTop() {
        if (priorityQueue.isEmpty()) {
            return -1;
        }
        Map.Entry<Long, Task> entry = priorityQueue.lastEntry();
        Task t = entry.getValue();
        priorityQueue.remove(entry.getKey());
        taskMap.remove(t.taskId);
        
        return t.userId;
    }
}©leetcode