/*

 Copyright or © or Copr. Ecole des Mines d'Alès (2012) 

 This software is a computer program whose purpose is to 
 process semantic graphs.

 This software is governed by the CeCILL  license under French law and
 abiding by the rules of distribution of free software.  You can  use, 
 modify and/ or redistribute the software under the terms of the CeCILL
 license as circulated by CEA, CNRS and INRIA at the following URL
 "http://www.cecill.info". 

 As a counterpart to the access to the source code and  rights to copy,
 modify and redistribute granted by the license, users are provided only
 with a limited warranty  and the software's author,  the holder of the
 economic rights,  and the successive licensors  have only  limited
 liability. 

 In this respect, the user's attention is drawn to the risks associated
 with loading,  using,  modifying and/or developing or reproducing the
 software by the user in light of its specific status of free software,
 that may mean  that it is complicated to manipulate,  and  that  also
 therefore means  that it is reserved for developers  and  experienced
 professionals having in-depth computer knowledge. Users are therefore
 encouraged to load and test the software's suitability as regards their
 requirements in conditions enabling the security of their systems and/or 
 data to be ensured and,  more generally, to use and operate it in the 
 same conditions as regards security. 

 The fact that you are presently reading this means that you have had
 knowledge of the CeCILL license and that you accept its terms.

 */
package slib.sml.sm.core.measures.others.groupwise.indirect;

import slib.sml.sm.core.measures.others.groupwise.indirect.experimental.Sim_groupwise_general_abstract;
import java.util.Set;
import org.openrdf.model.URI;

import slib.sml.sm.core.engine.SM_Engine;
import slib.sml.sm.core.utils.SMconf;
import slib.utils.ex.SLIB_Ex_Critic;
import slib.utils.impl.MatrixDouble;

/**
 * Lord P: Investigating semantic similarity measures across the Gene Ontology:
 * the relationship between sequence and annotation. Bioinformatics 2003,
 * 19:1275–1283.
 *
 * As described in:
 *
 * Schlicker A, Domingues FS, Rahnenführer J, Lengauer T: A new measure for
 * functional similarity of gene products based on Gene Ontology. BMC
 * Bioinformatics 2006, 7:302.
 * 
 * Corresponds to the Average Strategy
 *
 * @author Sébastien Harispe
 */
public class Sim_groupwise_Lord_2003 extends Sim_groupwise_general_abstract {

    @Override
    public double sim(Set<URI> setA, Set<URI> setB, SM_Engine rc, SMconf groupwiseconf, SMconf conf) throws SLIB_Ex_Critic {

        MatrixDouble<URI, URI> results_setA = rc.getMatrixScore(setA, setB, conf);
        return sim(results_setA);
    }

    public static double sim(MatrixDouble<URI, URI> matrix) {
        double sum = matrix.getSum();

        return 1. / (matrix.getNbColumns() * matrix.getNbRows()) * sum;
    }
}