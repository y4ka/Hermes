function inputButton(idPylon, idButton)
{
	var test = scenario.getDa().get(0);
		
	return test;
}

function tick(nbTick)
{
	//On r�cup�re le nombre de Pylones:
	var nbPylons = scenario.getNumberOfPylons();
	
	//On r�cup�re le nombre d'�quipes:
	var nbTeams = scenario.getNumberOfTeams();
	
	for (i = 0; i < nbTeams; i++) 
	{
    	text += "The number is " + i + "<br>";
	}
	
	//On r�cup�re le nombre de Pylones captur�s par chaque �quipe:
	
	
	return 0;
	
}