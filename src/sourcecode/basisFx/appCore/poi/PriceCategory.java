package basisFx.appCore.poi;

import basisFx.domain.price.TNPProduct;

import java.util.ArrayList;

public class PriceCategory {
     
            String name;
            
            
            ArrayList<TNPProduct>  categoryFilds;
            
            public void setName(String n){
                this.name=n;
            }
            public String getName() {
                return name;
            }
            public ArrayList<TNPProduct> getFilds() {
                return categoryFilds;
            }
            public void setFilds(ArrayList<TNPProduct> filds) {
                this.categoryFilds = filds;
            }

}
