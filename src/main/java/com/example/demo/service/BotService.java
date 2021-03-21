package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.common.CurrentPosition;
import com.example.demo.common.Input;
import com.example.demo.common.Move;

@Service
public class BotService {

	public CurrentPosition getFinalPosition(Input input) {
		CurrentPosition curr = new CurrentPosition();
		curr.setPosition(input.getPosition());
		if(input.getMove()!=null) {
			List<Move> moves = input.getMove();
			for (Move move : moves) {
				if(move.getL()!=0) {
					int div = move.getL()/90;
					for(int i=0;i<div;i++) {
						if(curr.getPosition().getDirection().equals("N"))
							curr.getPosition().setDirection("W");
						else if(curr.getPosition().getDirection().equals("W"))
							curr.getPosition().setDirection("S");
						else if(curr.getPosition().getDirection().equals("S"))
							curr.getPosition().setDirection("E");
						else if(curr.getPosition().getDirection().equals("E"))
							curr.getPosition().setDirection("N");
					}
				}else if(move.getR()!=0) {
					int div = move.getR()/90;
					for(int i=0;i<div;i++) {
						if(curr.getPosition().getDirection().equals("N"))
							curr.getPosition().setDirection("E");
						else if(curr.getPosition().getDirection().equals("E"))
							curr.getPosition().setDirection("S");
						else if(curr.getPosition().getDirection().equals("S"))
							curr.getPosition().setDirection("W");
						else if(curr.getPosition().getDirection().equals("W"))
							curr.getPosition().setDirection("N");
					}
				}
				if(move.getF()!=0) {
					if(curr.getPosition().getDirection().equals("N")) 
						curr.getPosition().setY(curr.getPosition().getY()+move.getF());
					else if(curr.getPosition().getDirection().equals("S"))
						curr.getPosition().setY(curr.getPosition().getY()-move.getF());
					else if(curr.getPosition().getDirection().equals("E"))
						curr.getPosition().setX(curr.getPosition().getX()+move.getF());
					else if(curr.getPosition().getDirection().equals("W"))
						curr.getPosition().setX(curr.getPosition().getX()-move.getF());
				}else if(move.getB()!=0) {
					if(curr.getPosition().getDirection().equals("N")) 
						curr.getPosition().setY(curr.getPosition().getY()-move.getB());
					else if(curr.getPosition().getDirection().equals("S"))
						curr.getPosition().setY(curr.getPosition().getY()+move.getB());
					else if(curr.getPosition().getDirection().equals("E"))
						curr.getPosition().setX(curr.getPosition().getX()-move.getB());
					else if(curr.getPosition().getDirection().equals("W"))
						curr.getPosition().setX(curr.getPosition().getX()+move.getB());
				}
			}
		}


		return curr;
	}
}

