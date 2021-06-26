/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alamia
 */
package pyramidspkg;

import java.io.IOException;

public class MainClass
{
	public static void main(String[] args) 
	{
		String path = "pyramids.csv";

		new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				try
				{
 //create an instance
				PyramidDao nPyramidsDao = new PyramidDaoImp();
// Read Data
				nPyramidsDao.readAllPyramidsfromCSV(path); 	
// Sort by height(descending=true)
				nPyramidsDao.sortPyramids_by_Height(true); 

				
				System.out.println(" Sorted Pyramids Data by Height ___");
				int i = 0;
				for(Pyramid pr:nPyramidsDao.getPyramids())
				{
					System.out.println("#"+(i++)+pr); 
				}
				
				System.out.println(" Number of Pyramids in each Site ___");
				System.out.println(nPyramidsDao.getSites_Dict());
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}).start();
			


 
	}
}

