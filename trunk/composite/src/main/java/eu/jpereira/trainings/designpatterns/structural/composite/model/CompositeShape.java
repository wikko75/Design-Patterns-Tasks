/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.structural.composite.model;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Joao Pereira
 * 
 */
public abstract class CompositeShape extends Shape {

	List<Shape> shapes;

	public CompositeShape() {
		this.shapes = createShapesList();
	}

	/**
	 * Remove a shape from this shape childrens
	 * 
	 * @param shape
	 *            the shape to remove
	 * @return true if the shape was present and was removed, false if the shape
	 *         was not present
	 */
	public boolean removeShape(Shape shape) {
		// TODO: implement
		//  DONE:
		if (shapes.contains(shape)) {
			shapes.remove(shape);
			return true;
		}
		return false;
	}

	/**
	 * Return the total shapes count in case this is a composite
	 * 
	 * @return the total count of shapes if the shape is composite. -1 otherwise
	 */
	public int getShapeCount() {
		// TODO: implement
		int total = 0;
		if (this.asComposite() != null) {
			return this.shapes.size();
			}
		return -1;
	}

	/**
	 * Add a shape to this shape.
	 * 
	 * @param shape
	 *            The shape to add
	 * @throws ShapeDoesNotSupportChildren
	 *             if this shape is not a composite
	 */
	public void addShape(Shape shape) throws  ShapeDoesNotSupportChildren {
		// TODO: Implement
		try {
			if (this.asComposite() != null) {
				shapes.add(shape);
			}
		} catch (NullPointerException ex) {
			throw new ShapeDoesNotSupportChildren();
		}
	}

	public List<Shape> getShapes() {
		// TODO: Implement
		return shapes;    // moze lepiej??
	}

	/**
	 * @param circle
	 * @return
	 */
	public List<Shape> getShapesByType(ShapeType circle) {
		// TODO: Implement
		//  DONE:
		List<Shape> shapesByType = new ArrayList<>();
		for (Shape shape : shapes) {
			if (shape.getType().equals(circle)) {
				shapesByType.add(shape);
			}
		}
		return shapesByType;
	}

	/**
	 * Return all shapes that are leafs in the tree
	 * 
	 * @return
	 */
	public List<Shape> getLeafShapes() {
		// TODO: Implement
		//  DONE:
		List<Shape> leafShapes = new ArrayList<>();
		for (Shape shape : shapes) {
			if (shape.asComposite() == null) {
				leafShapes.add(shape);
			}
		}
		return leafShapes;
	}

	/**
	 * Factory method for the list of children of this shape
	 * 
	 * @return
	 */
	protected List<Shape> createShapesList() {    // chyba blad?
		// TODO: Implement
		//  DONE:
		return new ArrayList<>();
	}
}
