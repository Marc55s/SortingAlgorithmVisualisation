import java.util.ArrayList;
import java.util.LinkedList;

public class MergeSort extends Algorithm {
    LinkedList<LinkedList<Integer>> groups;

    public MergeSort(int startPosX, int startPosY, int width, int height) {
        super(startPosX, startPosY, width, height);
    }

    boolean flag = true;

    @Override
    public void algoStep() {
        if (flag) {
            groups = new LinkedList<LinkedList<Integer>>();
            for (int i = 0; i < getData().length; i++) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(getData()[i]);
                groups.add(list);
            }
            flag = false;
        }
        //Erstelle n Teillisten. (1 Element pro Liste) (Divide)
        //Solange mehrere Gruppen existieren:
        if (groups.size() > 1) {
            //Merge die ersten beiden Listen im vorrat und hänge die verbundene Liste hinten an.
            groups.addLast(merge(groups.removeFirst(), groups.removeFirst()));
        }
        //Überschreibe die unsortierte Liste mit der sortierten Version
        var temp = groups;
        LinkedList<Integer> m = new LinkedList<>();
        for (LinkedList<Integer> integers : temp) {
            for (Integer integer : integers) {
                m.add(integer);
            }
        }
        setData(m.toArray(getData()));

    }

    LinkedList<Integer> merge(LinkedList<Integer> linkeListe, LinkedList<Integer> rechteListe) {
        LinkedList<Integer> temp = new LinkedList<>();
        // Solange noch nicht beide Listen hinzugefügt worden
        while (!linkeListe.isEmpty() && !rechteListe.isEmpty()) {
            if (linkeListe.getFirst() <= rechteListe.getFirst()) {
                temp.addLast(linkeListe.removeFirst());
            } else {
                temp.addLast(rechteListe.removeFirst());
            }
        }
        // Füge Rest hinzu, falls etwas übrig ist.
        temp.addAll(linkeListe);
        temp.addAll(rechteListe);
        return temp;
    }
}
