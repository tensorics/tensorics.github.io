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

package org.tensorics.core.resolve.engine;

import org.tensorics.core.resolve.domain.ResolvingException;

/**
 * This exception is thrown by the dispatcher if, after one iteration of resolving (asking all the resolvers if they
 * could resolve anything), the amount of resolved nodes did not increase at all. This problem might point to some
 * expressions, where no resolvers could be found for.
 * 
 * @author kfuchsbe
 */
public class ResolvedContextDidNotGrowException extends ResolvingException {
    private static final long serialVersionUID = 1L;

    public ResolvedContextDidNotGrowException() {
        super("The Resolved Context did not grow during one iteration. This most probably means, "
                + "that some of the nodes cannot be resolved.");
    }
}