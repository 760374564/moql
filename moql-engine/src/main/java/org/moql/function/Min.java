/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.moql.function;

import org.moql.EntityMap;
import org.moql.Operand;
import org.moql.operand.function.AggregationFunction;
import org.moql.util.CompareHelper;

import java.util.List;

/**
 * 
 * @author Tang Tadin
 *
 */
public class Min extends AggregationFunction {
	
	public static final String FUNCTION_NAME = "min";
	
	protected Operand operand;
	
	protected Object min;
	
	public Min(List<Operand> parameters) {
		super(FUNCTION_NAME, 1, parameters);
		// TODO Auto-generated constructor stub
		operand = parameters.get(0);
	}
	
	@Override
	public void increment(EntityMap entityMap) {
		// TODO Auto-generated method stub
		Object obj = operand.operate(entityMap);
		if (obj == null) {
			return;
		}
		if (min == null)
			min = obj;
		else {
			if (CompareHelper.compare(min, obj) > 0)
				min = obj;
		}
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return min;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		min = null;
	}

}
