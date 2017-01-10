// @formatter:off
 /*******************************************************************************
 *
 * This file is part of tensorics.
 * 
 * Copyright (c) 2008-2011, CERN. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 ******************************************************************************/
// @formatter:on

package org.tensorics.core.quantity.operations;

import org.tensorics.core.quantity.QuantifiedValue;
import org.tensorics.core.quantity.options.BinaryOperationValidityStrategy;
import org.tensorics.core.quantity.options.QuantityEnvironment;

import com.google.common.base.Optional;

/**
 * @author kfuchsbe
 * @param <V>
 */
public class AbstractQuantityOperation<V> {

	private final QuantityEnvironment<V> mathsEnvironment;

	protected AbstractQuantityOperation(QuantityEnvironment<V> environment) {
		super();
		this.mathsEnvironment = environment;
	}

	protected QuantityEnvironment<V> environment() {
		return mathsEnvironment;
	}

	protected boolean validityFor(QuantifiedValue<V> leftOperand, QuantifiedValue<V> rightOperand) {
		return environment().options().get(BinaryOperationValidityStrategy.class)
				.validityForBinaryOperation(leftOperand, rightOperand);
	}

	protected Optional<V> productError(QuantifiedValue<V> leftOperand, QuantifiedValue<V> rightOperand) {
		return environment().errorPropagation().errorForProductAndDivision(leftOperand, rightOperand);
	}

}