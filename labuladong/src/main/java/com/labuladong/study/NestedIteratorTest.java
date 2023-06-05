package com.labuladong.study;

import java.util.ArrayList;
import java.util.List;

public class NestedIteratorTest {

    public static void main(String[] args) {
        List<NestedIterator.NestedInteger> nestedList = new ArrayList<>();

        NestedIterator.NestedInteger nestedInteger = new NestedIterator.NestedInteger() {
            @Override
            public boolean isInteger() {
                return true;
            }

            @Override
            public Integer getInteger() {
                return 1;
            }

            @Override
            public List<NestedIterator.NestedInteger> getList() {
                return null;
            }
        };

        NestedIterator.NestedInteger nestedInteger1 = new NestedIterator.NestedInteger() {
            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return null;
            }

            @Override
            public List<NestedIterator.NestedInteger> getList() {
                List<NestedIterator.NestedInteger> list = new ArrayList<>();
                list.add(nestedInteger);
                list.add(nestedInteger);
                return list;
            }
        };

        NestedIterator.NestedInteger nestedInteger2 = new NestedIterator.NestedInteger() {
            @Override
            public boolean isInteger() {
                return true;
            }

            @Override
            public Integer getInteger() {
                return 2;
            }

            @Override
            public List<NestedIterator.NestedInteger> getList() {
                return null;
            }
        };

        NestedIterator.NestedInteger nestedInteger3 = new NestedIterator.NestedInteger() {
            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return null;
            }

            @Override
            public List<NestedIterator.NestedInteger> getList() {
                List<NestedIterator.NestedInteger> list = new ArrayList<>();
                list.add(nestedInteger);
                list.add(nestedInteger);
                return list;
            }
        };

        nestedList.add(nestedInteger1);
        nestedList.add(nestedInteger2);
        nestedList.add(nestedInteger3);

        NestedIterator nestedIterator = new NestedIterator(nestedList);
        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }
    }

}
