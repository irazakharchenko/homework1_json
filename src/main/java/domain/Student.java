package domain;

import json.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private String name, surname;
    private Integer year;
    private Tuple<String, Integer>[] exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.exams = exams;
    }

    public JsonObject toJsonObject() {
        JsonObject to_return = new JsonObject(new JsonPair("name", new JsonString(name)),
                new JsonPair("surname", new JsonString(surname)), new JsonPair("year", new JsonNumber(year)));
        List<Json> array_exams = new ArrayList<>();
        //JsonObject[] array_exams = new JsonObject[exams.length];
        JsonObject jobj_exam;

        for (Tuple exam:
             exams) {

            jobj_exam = new JsonObject( new JsonPair("course", new JsonString(exam.key.toString())),
                    new JsonPair("mark", new JsonNumber((int)exam.value)),
                    new JsonPair("passed", new JsonBoolean((int)exam.value >2)));


            array_exams.add(jobj_exam);

        }
        //System.out.println(new JsonArray(array_exams).toJson());
        to_return.add(new JsonPair("exams", new JsonArray(array_exams)));
        //System.out.println(to_return.toJson());
        return to_return;
    }
}
