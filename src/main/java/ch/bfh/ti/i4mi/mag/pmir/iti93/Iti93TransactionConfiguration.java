/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.bfh.ti.i4mi.mag.pmir.iti93;

import ca.uhn.fhir.context.FhirVersionEnum;

import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionValidator;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditDataset;

/**
 * Standard Configuration for Iti93Component. Lazy-loading of results is by default not supported.
 *
 */
public class Iti93TransactionConfiguration extends FhirTransactionConfiguration<Iti93AuditDataset> {

    public Iti93TransactionConfiguration() {
        super( 
                "pmir-iti93",
                "PMIR Mobile Patient Identity Feed",
                false,
                new Iti93AuditStrategy(false),
                new Iti93AuditStrategy(true),
                FhirVersionEnum.R4,
                new Iti93ResourceProvider(),        // Consumer side. accept $ihe-pix operation
                null,
                FhirTransactionValidator.NO_VALIDATION);
        setSupportsLazyLoading(false);
    }

}
