/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Akinwale.Agbaje
 * Splits descriptor into its multiple parts.
 */
public class Descriptor {
    /**
     * Breaks the descriptor into its individual search descriptions.
     * descriptor is: clientCompany:none;shareUnit:none;numberOfShareholders:none;numberOfBondholders:none
     * @param descriptor the search description
     * @return a map of the individual search descriptions
     */
    public Map<String, String> decipherDescriptor(String descriptor) {
        Map<String, String> descriptorSplits = new HashMap<>();
        String[] individualSplit = descriptor.split(";");
        for (String singleDescriptor : individualSplit) {
            String[] keyAndValue = singleDescriptor.split(":");
            descriptorSplits.put(keyAndValue[0], keyAndValue[1]);
        }
        return descriptorSplits;
    }
}
