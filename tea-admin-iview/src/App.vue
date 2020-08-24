<style scoped>
.layout{
    border: 1px solid #d7dde4;
    background: #f5f7f9;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
}
.layout-logo{
    width: 100px;
    height: 30px;
    background: #5b6270;
    border-radius: 3px;
    float: left;
    position: relative;
    top: 15px;
    left: 20px;
}
.layout-nav{
    width: 420px;
    margin: 0 auto;
    margin-right: 20px;
}
.layout-footer-center{
    text-align: center;
}
</style>
<template>
    <div class="layout">
        <Layout>
            <Header>
                <Menu mode="horizontal" theme="dark" active-name="1">
                    <div class="layout-logo">
                        <!-- <img alt="Vue logo" src="assets/logo.png"> -->
                    </div>
                    <div class="layout-nav">
                        
                        <MenuItem name="/TeaCategoryManage" to="/TeaCategoryManage" style="position: absolute;right: 0px;">
                            <Icon type="ios-keypad"></Icon>
                            Tea Management
                        </MenuItem>
                        
                    </div>
                </Menu>
            </Header>
            
            <Layout :style="{padding: '0 50px'}">
                
                <Content :style="{padding: '24px 0', minHeight: '280px', background: '#fff'}">
                    <Layout>
                        <Sider hide-trigger :style="{background: '#fff'}">
                            <Menu active-name="1-2" theme="light" width="auto" :open-names="['1']">
                                
                                <Submenu name="/TeaCategoryManage" to="/TeaCategoryManage">
                                    <template slot="title">
                                        <Icon type="ios-keypad"></Icon>
                                        TeaCategory Manage
                                    </template>
                                    <MenuItem name="/TeaCategoryManage" to="/TeaCategoryManage">Search TeaCategory</MenuItem>
                                    <MenuItem name="/AddTeaCategory" to="/AddTeaCategory">Add TeaCategory</MenuItem>
                                </Submenu>
                                <Submenu name="/TeaInfoManage" to="/TeaInfoManage">
                                    <template slot="title">
                                        <Icon type="ios-keypad"></Icon>
                                        TeaInfo Manage
                                    </template>
                                    <MenuItem name="/TeaInfoManage" to="/TeaInfoManage">Search TeaInfo</MenuItem>
                                    <MenuItem name="/AddTeaInfo" to="/AddTeaInfo">Add TeaInfo</MenuItem>
                                </Submenu>
                                
                            </Menu>
                        </Sider>
                        <Content :style="{padding: '24px', minHeight: '280px', background: '#fff'}">
                            <router-view/>
                        </Content>
                    </Layout>
                </Content>
            </Layout>
            <Footer class="layout-footer-center">2020-2030 &copy; DevelopByJohn</Footer>
        </Layout>
    </div>
</template>
<script>
    export default {
        
    }
</script>
