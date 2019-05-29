//SelectApplicaton

return['Master','SWIFT']

//SelectEnv

def xmlfile='E:\\DevOps\\ServerConfig.xml'
def xmlcontent=new File(xmlfile).text

def dataObj = new XmlParser().parseText(xmlcontent)
def apps=[]

def appseach=dataObj.Application

def test = dataObj.Application.findAll { app -> app.'@Name' == SelectApplication }
//print (test)

for (t in test){
 //apps.add("${app['@Name']}")
  print(t)
  
  for(t1 in t){
  	apps.add(t1.'@Name')
  }

}

return apps

//SelectServer

def xmlfile='E:\\DevOps\\ServerConfig.xml'
def xmlcontent=new File(xmlfile).text

def dataObj = new XmlParser().parseText(xmlcontent)
def apps=[]

def appseach=dataObj.Application

def test = dataObj.Application.findAll { app -> app.'@Name' == SelectApplication }
//print (test)


for (t in test){
 serverNodes = t.Environment.findAll { app -> app.'@Name' == SelectEnv }
  //println(serverNodes)
 for(t1 in serverNodes.Server){
   //println(t1)
   for(t2 in t1){
     //print(t2)
  	 apps.add(t2.'@Name')
   }
  }

}

return apps

//SelectService

Return['app','prcs','appbatch','pia']

//SelectAction

return['start','stop','status']


