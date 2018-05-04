# 处理循环引用导致的无限递归

## 出现的场景

如多对多关系中的相互引用，下面代码中Student与Project相互引用，在序列化时，则会抛出`com.fasterxml.jackson.databind.JsonMappingException: Infinite recursion (StackOverflowError)`

```
public class InfiniteRecursionTest {

    @Test
    public void test01() throws JsonProcessingException {
        Student student = new Student();
        Project project = new Project();

        student.setId(11111111L);
        project.setId(22222222L);

        List<Student> students = new ArrayList<>();
        List<Project> projects = new ArrayList<>();
        students.add(student);
        projects.add(project);

        student.setProjects(projects);
        project.setStudents(students);

        JsonUtil.getObjectMapper().writeValueAsString(student);
    }

    public static class Student {

        private Long id;

//        @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
        private List<Project> projects;

        public List<Project> getProjects() {
            return projects;
        }

        public void setProjects(List<Project> projects) {
            this.projects = projects;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "projects=" + projects +
                    '}';
        }
    }

//    @JsonIgnoreProperties("students")
    public static class Project {

        private Long id;

        private List<Student> students;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public List<Student> getStudents() {
            return students;
        }

        public void setStudents(List<Student> students) {
            this.students = students;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "students=" + students +
                    '}';
        }

    }
}
```

## 解决办法

### @JsonIdentityInfo

此注解的含义是，第一次遇到时序列化，后续遇到相同的实例时，会使用id代替。

如在`projects`加上此注解


```
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
private List<Project> projects;
```


![](/assets/1525399779957.png)

### @JsonIgnoreProperties

忽略掉造成错误的属性。

