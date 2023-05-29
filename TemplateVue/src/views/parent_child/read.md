todo

（2）在父组件中：
<Child v-model="isChild"></Child>    
<Child v-bind:value="isChild" v-on:input="isChild=$event"></Child>
<Child :value="isChild" @input="isChild=$event"></Child>
