/*
 * AUTHOR: Cooper Harris
 * FILE: PatientQueue.java
 * PURPOSE This program creates a priority queue backed by a 
 * binary minimum heap array. 
 * 
 * USAGE: This array holds data of type Patient, an object
 * representing a patient with the fields name and priority.
 */

public class PatientQueue {
    private static final int DEFAULT_SIZE = 10;
    private Patient[] array;
    private int size;

    public PatientQueue() {
        array = new Patient[DEFAULT_SIZE];
        size = 1;
    }

    /*
     * Helper method to grow the size of the array backing the queue
     * 
     * @return null
     */
    private void growArray() {
        Patient[] newArray = new Patient[2 * array.length];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    /*
     * Add an element to the back of the queue. It will then be bubbled
     * up if neccessary.
     * 
     * @param patient - The patient object to be enqueued
     * 
     * @reurn null
     */
    public void enqueue(Patient patient) {
        if (array.length == size) {
            growArray();
        }

        array[size] = patient;

        if (size > 1) {
            bubbleUp(size);
        }
        size++;
    }

    /*
     * Creates a patient object using the name and priority fields.
     * Then adds the patient to the back of the queue. It will then be bubbled
     * up if neccessary.
     * 
     * @param name - The name of the patient
     * 
     * @param priority - The priority of the patient
     * 
     * @reurn null
     */
    public void enqueue(String name, int priority) {
        Patient patient = new Patient(name, priority);

        enqueue(patient);
    }

    /*
     * A private helper method to handle shifting the
     * elements to their correct orders. This function
     * moves elements left if neccessary.
     * 
     * @Param index - the index of the current element
     * to be checked against its parent.
     * 
     * @Return null
     */
    private void bubbleUp(int index) {
        if (index > 1) {
            Patient parent = array[index / 2];
            Patient child = array[index];
            // swapping indeces of parent and child if child has lower priority
            if (parent.priority > child.priority) {
                array[index / 2] = child;
                array[index] = parent;
                // if the priority of two elements is equal, compare them
                // alphabetically
            } else if (parent.priority == child.priority) {
                if (child.name.compareTo(parent.name) < 0) {
                    array[index / 2] = child;
                    array[index] = parent;
                }
            }
            bubbleUp(index / 2);
        }
    }

    /*
     * Remove and return the name of the patient at index 1.
     * If the user attempts to dequeue from an empty throws
     * an IndexOutOfBounds exception.
     * 
     * @return the element at the front of the queue
     */
    public String dequeue() {
        if (size == 1) {
            throw new IndexOutOfBoundsException(
                    "There is nothing in the queue!");
        }

        Patient patientRemoved = array[1];

        array[1] = array[size - 1];
        array[size - 1] = null;

        bubbleDown(1);

        size--;

        return patientRemoved.name;
    }

    /*
     * A private helper method to handle shifting the
     * elements to their correct orders.
     * 
     * @Param index - the index of the current element
     * to be checked against its child. This function
     * moves elements right if neccessary.
     * 
     * @Return null
     */
    private void bubbleDown(int index) {
        if (index < size) {
            Patient parent = array[index];

            // Checking to make sure the child indeces are not out of bounds
            if ((index * 2) + 1 < array.length || (index * 2) < array.length) {
                Patient child1 = array[index * 2];
                Patient child2 = array[(index * 2) + 1];

                if (child1 != null) {
                    // Swapping with child1 if neccessary
                    if (parent.priority > child1.priority) {
                        array[index] = child1;
                        array[index * 2] = parent;
                        // if the priority of two elements is equal, compare
                        // them alphabetically
                    } else if (parent.priority == child1.priority) {
                        if (child1.name.compareTo(parent.name) < 0) {
                            array[index / 2] = child1;
                            array[index] = parent;
                        }
                    }
                    if (child2 != null) {
                        // Swapping with child2 if neccessary
                        if (parent.priority > child2.priority) {
                            array[index] = child2;
                            array[(index * 2) + 1] = parent;
                            // if the priority of two elements is equal, compare
                            // them alphabetically
                        } else if (parent.priority == child2.priority) {
                            if (child2.name.compareTo(parent.name) < 0) {
                                array[index / 2] = child2;
                                array[index] = parent;
                            }
                        }
                    }
                }
            }
            bubbleDown(index * 2);
        }
    }

    /*
     * Returns the name of the patient at index
     * one but does not alter the queue.
     */
    public String peek() {
        if (size == 1) {
            throw new IndexOutOfBoundsException(
                    "There is nothing in the queue!");
        }

        return array[1].name;
    }

    /*
     * Returns the priority of the patient at index
     * one but does not alter the queue.
     */
    public int peekPriority() {
        if (size == 1) {
            throw new IndexOutOfBoundsException(
                    "There is nothing in the queue!");
        }

        return array[1].priority;
    }

    /*
     * Changes the priority of a patient witht the name given and adjusts
     * the queue accordingly.
     * 
     * @Param name - name of the patient to change priority for
     * 
     * @Param newPriority - the priority to change to for the patient
     * 
     * @return null
     */
    public void changePriority(String name, int newPriority) {
        int timesFound = 0;
        for (int i = 1; i < size; i++) {
            if (array[i].name.equals(name) && timesFound < 1) {
                int prevPriority = array[i].priority;
                array[i].priority = newPriority;

                if (prevPriority < newPriority) {
                    bubbleDown(i);
                } else {
                    bubbleUp(i);
                }

                timesFound++;
            }
        }
    }

    /*
     * Returns true if the queue has no elements.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * Returns the number of elements in the queue.
     */
    public int size() {
        return size - 1;
    }

    /*
     * Removes all elements from the queue.
     * 
     * @return null
     */
    public void clear() {
        array = new Patient[array.length];
        size = 1;
    }

    /*
     * ToString method that returns the queue in the form
     * {name, (priority), name (priority)}
     * 
     * @return ret - String representing queue
     */
    @Override
    public String toString() {
        String ret = "{";

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                ret += array[i].toString() + ", ";
            }
        }
        if (ret.length() >= 2) {
            ret = ret.substring(0, ret.length() - 2);
        }

        ret += "}";

        return ret;
    }
}
