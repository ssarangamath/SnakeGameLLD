package org.example.dtos;

import org.example.business.exception.InvalidDirectionException;

import java.util.HashSet;
import java.util.Set;

public enum Direction {
    LEFT, RIGHT, UP, DOWN;

    static Set<Direction> directionSet;
    static{
        directionSet = new HashSet<>();

        for(Direction direction: Direction.values()){
            directionSet.add(direction);
        }
    }

    public static boolean isValid(Direction direction){
        if(directionSet.contains(direction)){
            return true;
        }
        throw new InvalidDirectionException("Direction is Invalid");
    }
}
