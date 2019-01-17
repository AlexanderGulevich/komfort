package basisFx.appCore.utils;

import basisFx.appCore.fabrics.WindowFabric;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.service.ServiceCrossWindow;
import basisFx.service.ServiceCrossWindowByDateResearch;

import java.util.HashMap;

public class Registry {
   public static WindowFabric windowFabric;
   public static WindowAbstraction mainWindow;
   public static HashMap<String, ServiceCrossWindow> serviceCrossWindowMap =new HashMap<>();


}