# Start with Azure Virtual Machine

## Get an Azure Account
**Student**
[Go to Azure Student](https://azure.microsoft.com/en-us/free/students/)
Click 'Start free', you may need your education email for verification, `example@yourschool.edu`
<img src = "image/azure-student.png"/>

**Not a student ?**
[Go to Microsoft Azure official website](https://azure.microsoft.com/en-us/)
Click 'Free account', After the decription due, you need to pay for the Virtual Machine
<img src = "/image/azure-official.png"/>

## Login to the Microsoft Azure
Go to
[Microsoft Azure](https://portal.azure.com)
Then login with your azure account
<img src = "/image/azure-login.png"/>

**After login Successfully**, you will see an Azure portal like this
<img src = "/image/azure-portal.png"/>
and click  **Create a resource**

## Create a virtual machine
You will see the icon of virtual machine then click `Create`
<img src = "/image/azure-create.png"/>
In this page we will set up our virtual machine
<img src = "image/virtual-machine.png"/>

**The inputs needed:**
<img src = "/image/inputs-vm.png"/>

Here we should choose `Authentication type` as **SSH public key**, which is a encoded key for us, so we can  have a remote connection with cloud virtual machine. The `Username` is the username of this machine, and the `Key pair name` is the name of your ssh key, they have tow files. Then go to `Disks`
<img src = "/image/create-auth.png"/>

For free account, we usually choose defualt size, extra space may have extra costs
<img src = "/image/create-disk.png"/>

Here, we will create a new `Virtual network` click **Create new**. and input your prefferd name, click **OK**.
<img src = "/image/create-vnet.png"/>

Here, we will create a `Public IP` address, select `Basic` and `Dynamic`. Don't worry for dynamic Public IP address. In fact,  Microsoft won't change your IP address. The static Public IP address will have extra cost. (If the option is disable, you should check your Availability options in **Baiscs**)
<img src = "/image/create-net.png"/>

**OK, well down.** We just finish the basic setting of our VM, which is enough, you can learn other settings from Internet or Microsoft official. For here, we can just click `Review + create` at bottom left.

After creation finished, go to `Resources` and click your Virtual Machine, the Overview Page should like this:
<img src = "/image/vm-overview.png"/>

We just finish creating the VM!