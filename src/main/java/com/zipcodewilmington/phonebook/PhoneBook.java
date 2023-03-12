package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;

    }

    public PhoneBook() {
        this(new LinkedHashMap<>());

    }

    public void add(String name, String phoneNumber) {

        if (!phonebook.containsKey(name)) {
            List<String> joeNumbers = new ArrayList<>();
            phonebook.put(name, joeNumbers);
        }
        List<String> joeNumbers = phonebook.get(name);
        joeNumbers.add(phoneNumber);


    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> joeNumbers = phonebook.get(name);
        if (phonebook.containsKey(name)) {
            for (int i = 0; i < phoneNumbers.length; i++) {
                joeNumbers.add(phoneNumbers[i]);
            }
            phonebook.put(name, joeNumbers);
        } else {
            List<String> newNumbers = new ArrayList<>();
            for (int i = 0; i < phoneNumbers.length; i++) {
                newNumbers.add(phoneNumbers[i]);
            }
            phonebook.put(name, newNumbers);
        }

    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    // this function returns true if the person has an entry in the phonebook.. false if not
    public Boolean hasEntry(String name) {
        boolean hasKey = phonebook.containsKey(name);

        return hasKey;
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    // this function takes a phone num and search through every number list to see who it belongs to

    public String reverseLookup(String phoneNumber) {
        // might want to look up how to iterate LinkedHashMap

        String lookUp = "";
        for(Map.Entry<String, List<String>> numbers : phonebook.entrySet()) {
            if (numbers.getValue().contains(phoneNumber)) {
                lookUp = numbers.getKey();
            }
        } return lookUp;
    }

    public List<String> getAllContactNames() {

        List<String> result = new ArrayList<>();
        for (String key:phonebook.keySet()) {
            result.add(key);
        }
        return result;
    }



    // this function returns the internal map of the phonebook
    // we use a public function to return it because the variable itself is private
    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
