package com.xpanxion.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Cat;
import com.xpanxion.java.assignments.model.Department;
import com.xpanxion.java.assignments.model.Person;
import com.xpanxion.java.assignments.model.PersonCat;
import com.xpanxion.java.assignments.model.Product;


public class Worker {
    public void ex1 () {
        // System.out.println("Start here");
        DataAccess data  = new DataAccess();
        System.out.println(DataAccess.getProducts().stream()
        .map(f -> new Product(f.getId(), f.getDepartmentId(), DataAccess.getDepartments().get(f.getDepartmentId()-1).getName(), f.getName(), f.getPrice(), f.getSku()))
        .collect(Collectors.toList()));
        }

    public void ex2(){
         System.out.println(DataAccess.getProducts().stream()
        .map(f -> new Product(f.getId(), f.getDepartmentId(), "N/A", f.getName(), f.getPrice(), f.getSku()))
        .collect(Collectors.toList()));
        }
    public void ex3(){
         System.out.println(DataAccess.getProducts().stream()
        .map(f -> new Product(f.getId(), f.getDepartmentId(), DataAccess.getDepartments().get(f.getDepartmentId()-1).getName(), f.getName(), f.getPrice(), f.getSku())).filter(f -> f.getDepartmentId() ==1 && f.getPrice() >=10)
        .collect(Collectors.toList()));
        
    }

    public void ex4(){
        List<Product>productList = DataAccess.getProducts().stream()
        .map(f -> new Product(f.getId(), f.getDepartmentId(), DataAccess.getDepartments().get(f.getDepartmentId()-1).getName(), f.getName(), f.getPrice(), f.getSku()))
        .collect(Collectors.toList());
        Double sum = productList.stream().filter(Product->Product.getDepartmentName().equals("Food")).mapToDouble(Product::getPrice).sum();
        System.out.println(sum);
        
    }

    public void ex5(){
        List<Person> personList = DataAccess.getPeople().stream().map(p -> new Person(p.getId(), p.getFirstName(), p.getLastName(), p.getAge(), p.getSsn().substring(p.getSsn().length()-4, p.getSsn().length()))).filter(p -> p.getId() <= 3).collect(Collectors.toList());
        System.out.println(personList);
    }

    public void ex6(){
        List<Cat> catList = DataAccess.getCats();

        for(int i = 0; i < catList.size();i++){
            for (int j = 0; j < catList.size(); j++){
                if(catList.get(i).compareTo(catList.get(j)) < 0){
                    Cat temp = catList.get(i);
                    catList.set(i, catList.get(j));
                    catList.set(j,temp);
                }
            }
        }
        System.out.println(catList);
    }
    public void ex7(){
        var wordHashMap = new HashMap<String, Integer>();
    
       List<String> wordList = new ArrayList<String>(Arrays.asList(DataAccess.getWords().split(" ")));        
       for (String word : wordList) {
           if (wordHashMap.containsKey(word)) {
               // Increment the count for this word.
               var count = wordHashMap.get(word);
               wordHashMap.put(word, ++count);
           } else {
               // Add the word to the HashMap for the first time.
               wordHashMap.put(word, 1);
           }
        }
        
        // sorting the hashmap
        List<String> keys = new ArrayList<>(wordHashMap.keySet());
        Collections.sort(keys);

        var keySet = wordHashMap.keySet();
        for (String key : keys) {
            System.out.println(key + " = " + wordHashMap.get(key));
        }
    }

    public void ex8(){
        List<Person> personList = DataAccess.getPeople().stream().map(p -> new Person(p.getId(), p.getFirstName(), "null", 0, "null")).collect(Collectors.toList());
        System.out.println(personList);
    }

    public void ex9(){
        List<Product>productList = DataAccess.getProducts().stream()
        .map(f -> new Product(f.getId(), f.getDepartmentId(), DataAccess.getDepartments().get(f.getDepartmentId()-1).getName(), f.getName(), f.getPrice(), f.getSku()))
        .collect(Collectors.toList());
        productList =  productList.stream().filter(f->f.getDepartmentName().equals("Electronics")).map(f-> new Product(f.getId(), f.getDepartmentId(), f.getDepartmentName(), f.getName(), f.getPrice()+2, f.getSku())).collect(Collectors.toList());
        Double sum = productList.stream().filter(Product->Product.getDepartmentName().equals("Electronics")).mapToDouble(Product::getPrice).sum();
        System.out.println("$" +sum);
    }

    public void ex10(){
        List<Cat> catList = DataAccess.getCats();
        List<Person> personList = DataAccess.getPeople();
        List<PersonCat> pc = new ArrayList<>();
        
        //pc.stream.map(personCat -> new PersonCat(personList.getId(i),personList.get() ))
        for(int i = 0; i < personList.size(); i++){
            pc.add(new PersonCat(i + 1, personList.get(i).getFirstName(), catList));
        }
        for (PersonCat p : pc){
            System.out.println();
        }
        
    }
}
