### Java: Streams
    
**Components of Streams:** 

- **Data sources** (e.g., a Collection) as the start of the pipeline.
- **Intermediate Operations** as processing steps.
- **Terminal Operations** as the end of the pipeline to compute a result.

### Map:

- Which universities do the students attend?

```java
public class Streams {

    public static void main(String[] args){
        Student anna = new Student("Anna", 1, "TU");
        Student max = new Student("Max",2, "HU");
        Student sam = new Student("sam",3, "FU");

        List<Student> students = new ArrayList<>();
        students.add(anna);
        students.add(max);
        students.add(sam);

        List<String> unis = students.stream()
                                    .map((x) -> x.university)
                                    .toList();

        System.out.println(unis);  //[TU, HU, FU]

    }

}

class Student{
    String name;
    int id;
    String university;

    public Student(String name, int id, String university){
        this.name = name;
        this.id = id;
        this.university = university;
    }

}
```


### Filter:

- Who attends TU?

```java
public static void main(String[] args){
        Student anna = new Student("Anna", 1, "TU");
        Student max = new Student("Max",2, "HU");
        Student sam = new Student("sam",3, "FU");

        List<Student> students = new ArrayList<>();
        students.add(anna);
        students.add(max);
        students.add(sam);

        List<Student> tuStudents = students.stream()
                .filter((x) -> x.university.equals("TU"))
                .collect(Collectors.toList());

        tuStudents.forEach((x) -> System.out.println(x.name));
        //Anna
        //Anna
    }
```


### Reduce:

- Sum up the IDs of the students

```java
public static void main(String[] args){
        Student anna = new Student("Anna", 1, "TU");
        Student max = new Student("Max",2, "HU");
        Student sam = new Student("sam",3, "FU");

        List<Student> students = new ArrayList<>();
        students.add(anna);
        students.add(max);
        students.add(sam);

        int sum = students.stream()
                        .map(student -> student.id)
                        .reduce(0, (acc, id) -> acc + id);
        
        System.out.println(sum);
        //6
    }
```