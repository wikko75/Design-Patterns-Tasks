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


import java.util.List;

/**
 * @author jpereira
 * 
 */
public abstract class Shape {
	// The shape coordinates
	private int x;
	private int y;

	/**
	 * If this object is a CompositeShape, return it. Null otherwise.
	 * 
	 * @return an compositeShape instance if this is a composite, null
	 *         otherwise
	 */
	public CompositeShape asComposite() {     // chyba blad
		//TODO: Implement
		// DONE:
		if (this.getType() != ShapeType.LINE) {
			return (CompositeShape) this;
		}
		return null;
	}

	/**
	 * Move a shape in a 2D scale
	 * 
	 * @param xIncrement
	 *            The increment in X axis
	 * @param yIncrement
	 *            The increment in the Y axis
	 */
	/*public void move(int xIncrement, int yIncrement) {
		if (this.asComposite() == null || this.asComposite().getShapeCount() == 0) {
			this.x += xIncrement;
			this.y += yIncrement;
		} else {
			// if is composite, delegate to children
			//TODO: Complete
			// DONE:
			// increment all children
			List<Shape> children = this.asComposite().getShapes();
			for (Shape shape : children) {
				shape.move(xIncrement, yIncrement);
			}
			// increment the parent
			this.x += xIncrement;
			this.y += yIncrement;
		}
	}*/
	public void move(int xIncrement, int yIncrement) {
		if (this.asComposite() != null) {
			// if composite, delegate to children (increment all children)
			List<Shape> children = this.asComposite().getShapes();
			for (Shape shape : children) {
				shape.move(xIncrement, yIncrement);
			}
		}
		// increment the parent (composite)
		this.x += xIncrement;
		this.y += yIncrement;
	}

	/**
	 * @return the x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x coordinate to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y coordinate to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Each instance of a Shape must know it's type
	 * @return
	 */
	public abstract ShapeType getType();

}
