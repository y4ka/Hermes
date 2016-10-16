function inputButton(idPylon, idButton)
{
	var test = scenario.getDa().get(0);
		
	return test;
}

function tick(nbTick)
{
	//On récupère le nombre de Pylones:
	var nbPylons = scenario.getNumberOfPylons();
	
	//On récupère le nombre d'équipes:
	var nbTeams = scenario.getNumberOfTeams();
	
	for (i = 0; i < nbTeams; i++) 
	{
    	text += "The number is " + i + "<br>";
	}
	
	//On récupère le nombre de Pylones capturés par chaque équipe:
	
	
	return 0;
	
}