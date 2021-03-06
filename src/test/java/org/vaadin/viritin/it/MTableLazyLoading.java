package org.vaadin.viritin.it;

import com.vaadin.annotations.Theme;
import com.vaadin.ui.Component;
import java.util.List;
import org.vaadin.addonhelpers.AbstractTest;
import org.vaadin.viritin.LazyList;
import org.vaadin.viritin.fields.MTable;
import org.vaadin.viritin.grid.MGrid;
import org.vaadin.viritin.testdomain.Person;
import org.vaadin.viritin.testdomain.Service;

/**
 *
 * @author Matti Tahvonen
 */
@Theme("valo")
public class MTableLazyLoading extends AbstractTest {

    @Override
    public Component getTestComponent() {

        MTable<Person> g = new MTable<Person>(
                new LazyList.PagingProvider<Person>() {

                    @Override
                    public List<Person> findEntities(int firstRow) {
                        return Service.findAll(firstRow,
                                LazyList.DEFAULT_PAGE_SIZE);
                    }
                },
                new LazyList.CountProvider() {

                    @Override
                    public int size() {
                        return (int) Service.count();
                    }
                }
        );
        return g;
    }

}
