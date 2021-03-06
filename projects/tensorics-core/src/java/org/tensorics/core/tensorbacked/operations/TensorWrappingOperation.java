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

package org.tensorics.core.tensorbacked.operations;

import org.tensorics.core.commons.operations.Conversion;
import org.tensorics.core.tensor.Tensor;
import org.tensorics.core.tensorbacked.Tensorbacked;
import org.tensorics.core.tensorbacked.TensorbackedInternals;

/**
 * The default implementation of an operation, which wraps a tensor into a tensorbacked object of a given type.
 * 
 * @author kfuchsbe
 * @param <V> the type of the values of the tensors and tensorbacked objects
 * @param <TB> the type of the tensorbacked objects into which tensors will be wrapped
 */
public class TensorWrappingOperation<V, TB extends Tensorbacked<V>> implements Conversion<Tensor<V>, TB> {

    private final Class<TB> tensorbackedClass;

    /**
     * The constructor, which requires a class which can wrap tensors
     * 
     * @param tensorbackedClass the type of the tensorbacked objects that will be created
     */
    public TensorWrappingOperation(Class<TB> tensorbackedClass) {
        super();
        this.tensorbackedClass = tensorbackedClass;
    }

    @Override
    public TB apply(Tensor<V> tensor) {
        return TensorbackedInternals.createBackedByTensor(tensorbackedClass, tensor);
    }

}
