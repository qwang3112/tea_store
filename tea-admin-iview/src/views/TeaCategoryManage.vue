<template>
    <div>
        <Table border :columns="columns" :data="tableData">
            <template slot-scope="{ row }" slot="name">
                <strong>{{ row.name }}</strong>
            </template>
            <template slot-scope="scope" slot="action">
                <Button type="primary" size="small" style="margin-right: 5px" @click="edit(scope.row)">modify</Button>
                <Button type="error" size="small" @click="deleteBook(scope.row)">delete</Button>
            </template>
        </Table>

        <Page :total="total" :page-size="pageSize" @on-change="page"/>

    </div>
</template>

<script>
    export default {
        methods: {
            deleteBook(row){
                const _this = this
                axios.delete('http://localhost:8181/admin/teaCategory/deleteById/'+row.categoryId).then(function(resp){
                    _this.$alert('《'+row.categoryName+'》Delete successfully！', 'Message', {
                        confirmButtonText: 'confirm',
                        callback: action => {
                            window.location.reload()
                        }
                    })
                })
            },
            edit(row) {
                this.$router.push({
                    path: '/updateTeaCategory',
                    query:{
                        id:row.categoryId
                    }
                })
            },
            page(currentPage){
                const _this = this
                axios.get('http://localhost:8181/admin/teaCategory/findAll/'+(currentPage-1)+'/6').then(function(resp){
                    // console.log(resp)
                    _this.tableData = resp.data.content
                    _this.pageSize = resp.data.size
                    _this.total = resp.data.totalElements
                })
            }
        },

        data() {
            return {
                pageSize:'1',
                total:'11',
                columns: [
                    {
                        title: 'Category',
                        key: 'categoryId'
                    },
                    {
                        title: 'Category name',
                        key: 'categoryName'
                    },
                    {
                        title: 'Category type',
                        key: 'categoryType'
                    },
                    {
                        title: 'create time',
                        key: 'createTime'
                    },
                    {
                        title: 'update time',
                        key: 'updateTime'
                    },
                    {
                        title: 'Action',
                        slot: 'action',
                        width: 200,
                        align: 'center'
                    }
                ],
                tableData: []
            }
        },

        created() {
            const _this = this
            axios.get('http://localhost:8181/admin/teaCategory/findAll/0/6').then(function(resp){
                // console.log(resp)
                _this.tableData = resp.data.content
                _this.pageSize = resp.data.size
                _this.total = resp.data.totalElements
            })
        }
    }
</script>