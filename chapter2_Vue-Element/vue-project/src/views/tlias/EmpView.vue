<template>
    <div>
        <el-container  style="height: 700px; border: 1px solid #eee">
            <el-header style="font-size:40px; background-color: rgb(238, 241, 246)">tlias 智能学习辅助系统</el-header>
            <el-container>
                <el-aside width="230px" style="border: 1px solid #eee">
                    <el-menu :default-openeds="['1', '3']">
                        <el-submenu index="1">
                            <template slot="title"><i class="el-icon-message"></i>系统信息管理</template>
                            <el-menu-item-group>
                                <template slot="title">分组一</template>
                                <el-menu-item index="1-1">
                                    <router-link to="/dept">部门管理</router-link>
                                </el-menu-item>
                                <el-menu-item index="1-2">
                                    <router-link to="/emp">员工管理</router-link>
                                </el-menu-item>
                            </el-menu-item-group>
                            <el-menu-item-group title="分组2">
                                <el-menu-item index="1-3">选项3</el-menu-item>
                            </el-menu-item-group>
                            <el-submenu index="1-4">
                                <template slot="title">选项4</template>
                                <el-menu-item index="1-4-1">选项4-1</el-menu-item>
                            </el-submenu>
                        </el-submenu>
                        </el-menu>
                </el-aside>


                <el-main>
                    <!-- 表单 -->
                    <el-form :inline="true" :model="searchForm" class="demo-form-inline">
                        <el-form-item label="姓名">
                            <el-input v-model="searchForm.name" placeholder="姓名"></el-input>
                        </el-form-item>

                        <el-form-item label="性别">
                            <el-select v-model="searchForm.gender" placeholder="性别">
                                <el-option label="男" value="1"></el-option>
                                <el-option label="女" value="2"></el-option>
                            </el-select>
                        </el-form-item>
                        
                        <el-form-item label="入职日期">
                            <!-- 日期选择器 -->
                            <el-date-picker
                                v-model="searchForm.entryDate"
                                type="daterange"
                                range-separator="至"
                                start-placeholder="开始日期"
                                end-placeholder="结束日期">
                            </el-date-picker>
                        </el-form-item>
                        
                        <el-form-item>
                            <el-button type="primary" @click="onSubmit()">查询</el-button>
                        </el-form-item>
                    </el-form>

                    <!-- 表格 -->
                    <el-table :data="tableData" border stripe>
                        <!-- prop 根据对应名字取得对应内容 -->
                        <el-table-column prop="name" label="姓名" width="180" align="center"></el-table-column>
                        <el-table-column label="图像" width="180" align="center">
                            <!-- 
                                <template slot-scope="scope"> 表示一个插槽,用于取得该表中其他 内容 
                                例如 获取该行 其他数据的值
                            -->
                            <!-- 通过 Scoped slot 可以获取到 row, column, $index 和 store（table 内部的状态管理）的数据，用法参考 demo。 -->
                            <template slot-scope="scope">
                                <img :src="scope.row.image" width="75px" height="80px" >
                            </template>
                        </el-table-column>
                        <el-table-column label="性别" width="140" align="center">
                            <template slot-scope="scope">
                                {{scope.row.gender == 1 ? '男':'女'}}
                            </template>
                        </el-table-column>
                        <el-table-column prop="job" label="职位" width="140" align="center"></el-table-column>
                        <el-table-column prop="entryDate" label="入职日期" width="180" align="center"></el-table-column>
                        <el-table-column prop="updateTime" label="最后操作时间" width="230" align="center"></el-table-column>
                        <el-table-column label="操作" align="center">
                            <el-button type="primary" size="mini">编辑</el-button>
                            <el-button type="danger" size="mini">删除</el-button>
                        </el-table-column>
                    </el-table>

                    <br>
                    
                    <!-- 分页条 -->
                    <!-- Pagination 分页 -->
                    <el-pagination background layout="total,sizes, prev, pager, next, jumper" 
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :total="1000"></el-pagination>

                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            tableData: [],
            searchForm: {
               name:"",
               gender:"",
               entryDate:[]
            }
        }
    },
    methods: {
        onSubmit:function(){
            alert("查询数据");
        },
        handleSizeChange:function(val){
            alert("每页记录数变化" + val)
        },
        handleCurrentChange:function(val){
            alert("页码发生变化" + val)
        }
    },
    mounted () {
        //发送异步请求,获取数据
        axios.get("https://yapi.pro/mock/372497/list").then((result) => {
            this.tableData = result.data.data;  
        });
    }
}
</script>

<style>

</style>